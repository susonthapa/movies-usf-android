package co.kaush.msusf.movies

data class ViewBox<T>(
    val value: T,
    private val isChanged: Boolean = true
) {

    fun stateCopy(
        value: T = this.value,
        isChanged: Boolean = false
    ): ViewBox<T> {
        return ViewBox(value, isChanged)
    }

    fun resetCopy(value: T = this.value): ViewBox<T> {
        return ViewBox(value)
    }

    fun getValueIfChanged(): T? {
        return if (isChanged) {
            value
        } else {
            null
        }
    }
}

data class ViewVisibility(
    val isShown: Boolean = false,
    val isAnimated: Boolean = false
)

data class ViewValue<T>(
    val value: T?,
    val visibility: ViewVisibility
)
