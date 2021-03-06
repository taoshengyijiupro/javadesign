package com.session.sessiontest1.ch8.VO;

/**
 * 任务处理后返回的结果实体类
 */
public class TaskResult<R> {

    private final TaskResultType resultType;//方法是否成功完成
    private final R returnValue;//方法处理后的结果数据
    private final String reason;//如果方法失败，这里可以填充原因

    public TaskResult(TaskResultType resultType, R returnValue, String reason) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = reason;
    }

    public TaskResult(TaskResultType resultType, R returnValue) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = "success";
    }

    public TaskResultType getResultType() {
        return resultType;
    }

    public String getReason() {
        return reason;
    }

    public R getReturnValue() {
        return returnValue;
    }

    @Override
    public String toString() {
        return "TaskResult [resultType=" + resultType
                + ", returnValue=" + returnValue
                + ", reason=" + reason + "]";
    }
}
