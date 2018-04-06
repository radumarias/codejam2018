package com.code42.codejam.solver;

import com.code42.codejam.io.SolutionWriter;
import com.code42.codejam.model.RequestModel;

public interface Solver {

    void solve(RequestModel requestModel, SolutionWriter writer);
}
