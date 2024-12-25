package com.example.nytimesapp.screens.topStoryItem

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.FragmentTopStoryItemBinding
import com.example.nytimesapp.di.ViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopStoryItemFragment : Fragment(R.layout.fragment_top_story_item) {

    private var _binding: FragmentTopStoryItemBinding? = null
    private val binding: FragmentTopStoryItemBinding
        get() = _binding ?: throw RuntimeException("TopStoryDetailFragment is null")

    private val component by lazy {
        (requireActivity().application as NewsApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TopStoryItemViewModel::class]
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopStoryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getItem = getItemByString()
        lifecycleScope.launch {
            viewModel.getTopStoryItemByTitle(getItem).collectLatest {
                binding.tvTitle.text = it.title
                binding.tvDesc.text = it.description
                binding.tvDate.text = it.publishedDate
            }
        }


    }

    private fun getItemByString(): String {
        return requireArguments().getString(EXTRA_TITLE_KEY, EMPTY_VALUE)
    }

    fun getInstance(title: String): Fragment {
        return TopStoryItemFragment().apply {
            arguments = Bundle().apply {
                putString(EXTRA_TITLE_KEY, title)
            }
        }
    }

    companion object {
        private const val EXTRA_TITLE_KEY = "title_key"
        private const val EMPTY_VALUE = ""



    }

}
