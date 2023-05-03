package Interfaces;

import Interfaces.ICarService;

public interface ICarTuning extends ICarService {
    void installSpoilers(boolean isSpoilersInStock) throws Exception;

    void tintingWindows();
}
