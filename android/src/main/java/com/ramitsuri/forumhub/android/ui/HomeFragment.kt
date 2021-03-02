package com.ramitsuri.forumhub.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ramitsuri.forumhub.android.R
import com.ramitsuri.forumhub.android.databinding.FragmentHomeBinding
import com.ramitsuri.forumhub.android.util.showPopupMenu
import com.ramitsuri.forumhub.android.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.btnFilter.setOnClickListener {
            showFilter()
        }
        binding.txtFilter.setOnClickListener {
            showFilter()
        }
    }

    private fun showFilter() {
        context?.showPopupMenu(binding.txtFilter, R.menu.menu_filter) { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_top -> {
                    binding.txtFilter.text = getString(R.string.filter_top)
                }
                R.id.menu_new -> {
                    binding.txtFilter.text = getString(R.string.filter_new)
                }
                R.id.menu_best -> {
                    binding.txtFilter.text = getString(R.string.filter_best)
                }
                R.id.menu_ask -> {
                    binding.txtFilter.text = getString(R.string.filter_ask)
                }
                R.id.menu_job -> {
                    binding.txtFilter.text = getString(R.string.filter_job)
                }
                R.id.menu_show -> {
                    binding.txtFilter.text = getString(R.string.filter_show)
                }
                else -> {

                }
            }
        }
    }
}