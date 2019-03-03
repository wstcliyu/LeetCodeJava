public class Generate_478 {

    double radius, x_center, y_center;

    public Generate_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        // The point is that we should not use rand() * radius to obtain len
        // we should use sqrt(rand()) * radius
        double len = Math.sqrt(Math.random()) * radius;

        // Note how to calculate the degree of an angel (and its cosine and sine) using Math.PI
        double deg = Math.random() * 2 * Math.PI;
        double x = x_center + len * Math.cos(deg);
        double y = y_center + len * Math.sin(deg);
        return new double[]{x, y};
    }
}
