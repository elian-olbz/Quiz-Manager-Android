package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.RouteInfo;

@Deprecated
public final class HttpRoute implements RouteInfo {
    public HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies, boolean secure, RouteInfo.TunnelType tunnelled, RouteInfo.LayerType layered) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy, boolean secure, RouteInfo.TunnelType tunnelled, RouteInfo.LayerType layered) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost target) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy, boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getTargetHost() {
        throw new RuntimeException("Stub!");
    }

    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    public int getHopCount() {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getHopTarget(int hop) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getProxyHost() {
        throw new RuntimeException("Stub!");
    }

    public RouteInfo.TunnelType getTunnelType() {
        throw new RuntimeException("Stub!");
    }

    public boolean isTunnelled() {
        throw new RuntimeException("Stub!");
    }

    public RouteInfo.LayerType getLayerType() {
        throw new RuntimeException("Stub!");
    }

    public boolean isLayered() {
        throw new RuntimeException("Stub!");
    }

    public boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
