package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner, OnBackPressedDispatcherOwner {
    @LayoutRes
    private int mContentLayoutId;
    private final LifecycleRegistry mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [androidx.activity.ComponentActivity$3, androidx.lifecycle.LifecycleObserver] */
    /* JADX WARNING: type inference failed for: r2v3, types: [androidx.activity.ImmLeaksCleaner, androidx.lifecycle.LifecycleObserver] */
    /* JADX WARNING: type inference failed for: r2v4, types: [androidx.activity.ComponentActivity$2, androidx.lifecycle.LifecycleObserver] */
    public ComponentActivity() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                ComponentActivity.super.onBackPressed();
            }
        });
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View decor = window != null ? window.peekDecorView() : null;
                        if (decor != null) {
                            decor.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().addObserver(new LifecycleEventObserver() {
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                    ComponentActivity.this.getViewModelStore().clear();
                }
            }
        });
        if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            getLifecycle().addObserver(new ImmLeaksCleaner(this));
        }
    }

    @ContentView
    public ComponentActivity(@LayoutRes int contentLayoutId) {
        this();
        this.mContentLayoutId = contentLayoutId;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSavedStateRegistryController.performRestore(savedInstanceState);
        ReportFragment.injectIfNeededIn(this);
        if (this.mContentLayoutId != 0) {
            setContentView(this.mContentLayoutId);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.mSavedStateRegistryController.performSave(outState);
    }

    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nc;
        Object custom = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nc = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nc.viewModelStore;
        }
        if (viewModelStore == null && custom == null) {
            return null;
        }
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.custom = custom;
        nci.viewModelStore = viewModelStore;
        return nci;
    }

    @Deprecated
    @Nullable
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Deprecated
    @Nullable
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nc = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nc != null) {
            return nc.custom;
        }
        return null;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nc = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nc != null) {
                this.mViewModelStore = nc.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
        return this.mViewModelStore;
    }

    @MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }
}
