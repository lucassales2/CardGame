package lucassales.com.br.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.reactivex.rxkotlin.plusAssign
import kotlinx.coroutines.launch
import lucassales.com.br.ui.base.BaseViewModel
import lucassales.com.core.solitaire.SolitaireRules
import lucassales.com.data.entities.relation.Solitaire
import lucassales.com.domain.AppSchedulers
import lucassales.com.domain.actions.TapDeckInteractor
import lucassales.com.domain.actions.TapWasteInteractor
import lucassales.com.domain.create.CreateGameInteractor
import lucassales.com.domain.launchInteractor
import lucassales.com.domain.runInteractor
import lucassales.com.domain.solitaire.GetMatchByIdInteractor
import timber.log.Timber

class MainViewModel(
    appSchedulers: AppSchedulers,
    createGameInteractor: CreateGameInteractor,
    getMatchByIdInteractor: GetMatchByIdInteractor,
    private val tapDeckInteractor: TapDeckInteractor,
    private val tapWasteInteractor: TapWasteInteractor
) : BaseViewModel() {
    private val _solitaire = MutableLiveData<Solitaire>()
    val solitaire: LiveData<Solitaire> = _solitaire

    private var matchId: Long = 0

    init {
        viewModelScope.launch {
            matchId = runInteractor(createGameInteractor,
                SolitaireRules
            )
            getMatchByIdInteractor.setParams(matchId)
        }

        disposables += getMatchByIdInteractor.observe()
            .subscribeOn(appSchedulers.io)
            .observeOn(appSchedulers.io)
            .subscribe(_solitaire::postValue, Timber::e)
    }

    fun onWasteClick() {
        viewModelScope.launchInteractor(tapWasteInteractor, matchId)
    }

    fun onDeckClick() {
        viewModelScope.launchInteractor(tapDeckInteractor, matchId)
    }
}
