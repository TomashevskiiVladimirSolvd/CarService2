package com.solvd.laba.Interfaces;

public interface ICarTuning extends ICarService {
    void installSpoilers(boolean isSpoilersInStock) throws Exception;

    void tintingWindows();
}
