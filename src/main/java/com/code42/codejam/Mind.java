package com.code42.codejam;

import com.code42.codejam.util.io.RequestReader;
import com.code42.codejam.util.io.SolutionWriter;
import com.code42.codejam.util.model.RequestModel;
import com.code42.codejam.util.solver.Solver;
import com.code42.codejam.util.solver.impl.RaduSolverImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Mind {

    private RequestReader reader;
    private Solver solver;

    public Mind() {
        reader = new RequestReader();
        solver = new RaduSolverImpl();
    }

    public void doYouMagic(InputStream in, OutputStream out) throws IOException {
        SolutionWriter writer = new SolutionWriter(out);
        RequestModel requestModel = reader.read(in);
        System.out.println("requestModel = " + requestModel);
        solver.solve(requestModel, writer);
    }
}
