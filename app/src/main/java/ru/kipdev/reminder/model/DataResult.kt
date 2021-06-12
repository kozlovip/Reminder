package ru.kipdev.reminder.model

open class DataResult<out T>(val status: Status, val data: T?, val exception: Throwable?, var handeled : Boolean = false) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        DONT_SUPPORT
    }

    companion object {
        fun <T> success(data: T): DataResult<T> {
            return DataResult(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: Throwable?): DataResult<T> {
            return DataResult(Status.ERROR, null, exception)
        }

        fun <T> loading(data: T? = null): DataResult<T> {
            return DataResult(Status.LOADING, data, null)
        }

        fun <T> dontSupport(data: T? = null): DataResult<T> {
            return DataResult(Status.DONT_SUPPORT, data, null)
        }

        fun <T> partialSuccess(old: DataResult<T>?, part: (T?) -> T, successCondition: (T) -> Boolean): DataResult<T> {
            val new = part(old?.data)
            return  if(successCondition(new))
                        DataResult(Status.SUCCESS, new, null)
                    else
                        DataResult(old?.status?: Status.DONT_SUPPORT, new, null)
        }
    }
}