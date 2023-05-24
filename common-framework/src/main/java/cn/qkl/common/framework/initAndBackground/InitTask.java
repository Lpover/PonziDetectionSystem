//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.qkl.common.framework.initAndBackground;

public interface InitTask extends BackgroundTask {
    default String getTaskType() {
        return "initTask";
    }

    default long getPeriod() {
        return 0L;
    }

    default long getDelay() {
        return 0L;
    }
}
