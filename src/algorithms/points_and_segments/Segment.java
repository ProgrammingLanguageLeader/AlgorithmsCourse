package algorithms.points_and_segments;

public class Segment {
    private Integer left;
    private Integer right;

    public Segment(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", left, right);
    }
}
