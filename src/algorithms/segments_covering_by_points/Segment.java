package algorithms.segments_covering_by_points;

public class Segment implements Comparable<Segment>
{
    private Integer left;
    private Integer right;
    private boolean marked;

    Segment(int left, int right) {
        this.left = left;
        this.right = right;
        marked = false;
    }

    @Override
    public int compareTo(Segment o) {
        return this.right.compareTo(o.right);
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
};
