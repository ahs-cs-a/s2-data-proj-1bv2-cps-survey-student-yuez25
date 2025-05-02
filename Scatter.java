import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class Scatter {

    public void displayScatterPlot(double[] x, double[] y) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scatter Plot Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(createChartPanel(x,y));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JPanel createChartPanel(double[] x, double[] y) {
        String chartTitle = "Log-Wages vs Education Years";
        String xAxisLabel = "Education Years";
        String yAxisLabel = "Log-Wages";

        XYDataset dataset = createDataset(x, y);

        JFreeChart chart = ChartFactory.createScatterPlot(
                chartTitle,
                xAxisLabel, yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return new ChartPanel(chart);
    }

    private static XYDataset createDataset(double[] x, double[] y) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = {
            x, // X values
            y  // Y values
        };
        dataset.addSeries("Scatter of Log Wage to Education", data);
        return dataset;
    }
}