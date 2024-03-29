package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class ShapePathModel {
    private static final CornerTreatment DEFAULT_CORNER_TREATMENT = new CornerTreatment();
    private static final EdgeTreatment DEFAULT_EDGE_TREATMENT = new EdgeTreatment();
    private EdgeTreatment bottomEdge = DEFAULT_EDGE_TREATMENT;
    private CornerTreatment bottomLeftCorner = DEFAULT_CORNER_TREATMENT;
    private CornerTreatment bottomRightCorner = DEFAULT_CORNER_TREATMENT;
    private EdgeTreatment leftEdge = DEFAULT_EDGE_TREATMENT;
    private EdgeTreatment rightEdge = DEFAULT_EDGE_TREATMENT;
    private EdgeTreatment topEdge = DEFAULT_EDGE_TREATMENT;
    private CornerTreatment topLeftCorner = DEFAULT_CORNER_TREATMENT;
    private CornerTreatment topRightCorner = DEFAULT_CORNER_TREATMENT;

    public void setAllCorners(CornerTreatment cornerTreatment) {
        this.topLeftCorner = cornerTreatment;
        this.topRightCorner = cornerTreatment;
        this.bottomRightCorner = cornerTreatment;
        this.bottomLeftCorner = cornerTreatment;
    }

    public void setAllEdges(EdgeTreatment edgeTreatment) {
        this.leftEdge = edgeTreatment;
        this.topEdge = edgeTreatment;
        this.rightEdge = edgeTreatment;
        this.bottomEdge = edgeTreatment;
    }

    public void setCornerTreatments(CornerTreatment topLeftCorner2, CornerTreatment topRightCorner2, CornerTreatment bottomRightCorner2, CornerTreatment bottomLeftCorner2) {
        this.topLeftCorner = topLeftCorner2;
        this.topRightCorner = topRightCorner2;
        this.bottomRightCorner = bottomRightCorner2;
        this.bottomLeftCorner = bottomLeftCorner2;
    }

    public void setEdgeTreatments(EdgeTreatment leftEdge2, EdgeTreatment topEdge2, EdgeTreatment rightEdge2, EdgeTreatment bottomEdge2) {
        this.leftEdge = leftEdge2;
        this.topEdge = topEdge2;
        this.rightEdge = rightEdge2;
        this.bottomEdge = bottomEdge2;
    }

    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public void setTopLeftCorner(CornerTreatment topLeftCorner2) {
        this.topLeftCorner = topLeftCorner2;
    }

    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public void setTopRightCorner(CornerTreatment topRightCorner2) {
        this.topRightCorner = topRightCorner2;
    }

    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public void setBottomRightCorner(CornerTreatment bottomRightCorner2) {
        this.bottomRightCorner = bottomRightCorner2;
    }

    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public void setBottomLeftCorner(CornerTreatment bottomLeftCorner2) {
        this.bottomLeftCorner = bottomLeftCorner2;
    }

    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public void setTopEdge(EdgeTreatment topEdge2) {
        this.topEdge = topEdge2;
    }

    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public void setRightEdge(EdgeTreatment rightEdge2) {
        this.rightEdge = rightEdge2;
    }

    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public void setBottomEdge(EdgeTreatment bottomEdge2) {
        this.bottomEdge = bottomEdge2;
    }

    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public void setLeftEdge(EdgeTreatment leftEdge2) {
        this.leftEdge = leftEdge2;
    }
}
