package com.example.polynomial;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;

import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {

    @BindView(R.id.textView4)
    TextView text;

    @BindView(R.id.graph_view)
    GraphView graphView;

    private List<Double> roots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity);
        ButterKnife.bind(this);

        Integer a = getIntent().getIntExtra("a", 0);
        Integer b = getIntent().getIntExtra("b", 0);
        Integer c = getIntent().getIntExtra("c", 0);

        text.setText(String.format("A=%d B=%d C=%d", a, b, c));

        Graph graph = new Graph.Builder()
                .addFunction(x -> a * x * x + b * x + c, Color.BLUE)
                .setWorldCoordinates(-20, 20, -20, 20)
                .setXTicks(new double[]{-15, -10, -5, 5, 10, 15})
                .setYTicks(new double[]{-15, -10, -5, 5, 10, 15})
                .build();
        graphView.setGraph(graph);
        setTitle(String.format("A=%d B=%d C=%d", a, b, c));

        roots = findRoots(a, b, c);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("roots", roots.toString());
        setResult(2, intent);
        super.onBackPressed();
    }

    private List<Double> findRoots(double a, double b, double c) {
        LaguerreSolver solver = new LaguerreSolver();
        Complex[] roots = solver.solveAllComplex(new double[]{c, b, a}, -20);
        return Arrays.stream(roots)
                .map(Complex::getReal)
                .collect(Collectors.toList());
    }

}
