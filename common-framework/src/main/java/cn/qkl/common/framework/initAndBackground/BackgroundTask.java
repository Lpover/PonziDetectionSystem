//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.qkl.common.framework.initAndBackground;

public interface BackgroundTask extends Runnable {
    default String getTaskType() {
        return "backgroundTask";
    }

    long getPeriod();

    long getDelay();

    String getName();
}
