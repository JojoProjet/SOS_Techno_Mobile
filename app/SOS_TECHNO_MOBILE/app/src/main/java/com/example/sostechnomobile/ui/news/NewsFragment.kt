package com.example.sostechnomobile.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sostechnomobile.databinding.FragmentNewsBinding
import com.example.sostechnomobile.util.getViewModelFactory

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val  viewModel by viewModels<NewsViewModel>{getViewModelFactory()}

    private  val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}