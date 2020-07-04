package co.kaush.msusf.movies

data class MSMovieViewState(
        val searchBoxText: ViewBox<String>? = null,
        val searchedMovieTitle: ViewBox<String> = ViewBox("", false),
        val searchedMovieRating: ViewBox<String> = ViewBox("", false),
        val searchedMoviePoster: ViewBox<String> = ViewBox("", false),
        val searchedMovieReference: ViewBox<MSMovie>? = null,
        val adapterList: ViewBox<List<MSMovie>> = ViewBox(listOf(), false)
) {

    fun stateCopy(
            searchBoxText: ViewBox<String>? = this.searchBoxText?.stateCopy(),
            searchedMovieTitle: ViewBox<String> = this.searchedMovieTitle.stateCopy(),
            searchedMovieRating: ViewBox<String> = this.searchedMovieRating.stateCopy(),
            searchedMoviePoster: ViewBox<String> = this.searchedMoviePoster.stateCopy(),
            searchedMovieReference: ViewBox<MSMovie>? = this.searchedMovieReference?.stateCopy(),
            adapterList: ViewBox<List<MSMovie>> = this.adapterList.stateCopy()
    ): MSMovieViewState {
        return MSMovieViewState(
                searchBoxText,
                searchedMovieTitle,
                searchedMovieRating,
                searchedMoviePoster,
                searchedMovieReference,
                adapterList
        )
    }

    fun resetCopy(
            searchBoxText: ViewBox<String>? = this.searchBoxText?.resetCopy(),
            searchedMovieTitle: ViewBox<String> = this.searchedMovieTitle.resetCopy(),
            searchedMovieRating: ViewBox<String> = this.searchedMovieRating.resetCopy(),
            searchedMoviePoster: ViewBox<String> = this.searchedMoviePoster.resetCopy(),
            searchedMovieReference: ViewBox<MSMovie>? = this.searchedMovieReference?.resetCopy(),
            adapterList: ViewBox<List<MSMovie>> = this.adapterList.resetCopy()
    ): MSMovieViewState {
        return MSMovieViewState(
                searchBoxText,
                searchedMovieTitle,
                searchedMovieRating,
                searchedMoviePoster,
                searchedMovieReference,
                adapterList
        )
    }
}

sealed class MSMovieViewEffect {
    object AddedToHistoryToastEffect : MSMovieViewEffect()
}

sealed class MSMovieEvent {
    object ScreenLoadEvent : MSMovieEvent()
    data class SearchMovieEvent(val searchedMovieTitle: String = "") : MSMovieEvent()
    data class AddToHistoryEvent(val searchedMovie: MSMovie) : MSMovieEvent()
    data class RestoreFromHistoryEvent(val movieFromHistory: MSMovie) : MSMovieEvent()
}

sealed class MSMovieResult {
    object ScreenLoadResult : MSMovieResult()
    data class SearchMovieResult(val movie: MSMovie) : MSMovieResult()
    data class AddToHistoryResult(val movie: MSMovie) : MSMovieResult()
}