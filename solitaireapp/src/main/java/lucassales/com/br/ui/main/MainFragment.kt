package lucassales.com.br.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_fragment.*
import lucassales.com.br.R
import lucassales.com.br.extensions.deckDrawable
import lucassales.com.br.extensions.wasteDrawable
import lucassales.com.br.util.observeNonNull
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wasteIb.setOnClickListener {
            viewModel.onWasteClick()
        }

        deckIb.setOnClickListener {
            viewModel.onDeckClick()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.solitaire.observeNonNull(this) { solitaire ->
            wasteIb.setImageResource(solitaire.wasteDrawable)
            deckIb.setImageResource(solitaire.deckDrawable)
        }
    }
}
