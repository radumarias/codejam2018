package com.code42.codejam.util.solver;

import com.code42.codejam.util.io.SolutionWriter;
import com.code42.codejam.util.model.RequestModel;

public interface Solver {

    void solve(RequestModel requestModel, SolutionWriter writer);
}
