package com.ramitsuri.forumhub.android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramitsuri.forumhub.android.R
import com.ramitsuri.forumhub.android.databinding.FragmentHomeBinding
import com.ramitsuri.forumhub.android.util.Logger
import com.ramitsuri.forumhub.android.util.showPopupMenu
import com.ramitsuri.forumhub.android.viewmodel.HomeViewModel
import com.ramitsuri.forumhub.shared.network.hn.HNStoryResponse

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

        val adapter = StoryListAdapter()
        adapter.setItems(
            listOf(
                HNStoryResponse(
                    id = 1,
                    creationTime = 1L,
                    title = "Title1",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 2,
                    creationTime = 2L,
                    title = "Title2",
                    author = "Author2",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 3,
                    creationTime = 3L,
                    title = "Title3",
                    author = "Author3",
                    score = 3,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 4,
                    creationTime = 4L,
                    title = "Title4",
                    author = "Author4",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 5,
                    creationTime = 1L,
                    title = "Title5",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 6,
                    creationTime = 6L,
                    title = "Title6",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 7,
                    creationTime = 1L,
                    title = "Title7",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 8,
                    creationTime = 1L,
                    title = "Title8",
                    author = "Author9",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 9,
                    creationTime = 9L,
                    title = "Title9",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 10,
                    creationTime = 1L,
                    title = "Title10",
                    author = "Author5",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 11,
                    creationTime = 1L,
                    title = "Title11",
                    author = "Author11",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 12,
                    creationTime = 1L,
                    title = "Title12",
                    author = "Author4",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 13,
                    creationTime = 1L,
                    title = "Title13",
                    author = "Author3",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 14,
                    creationTime = 1L,
                    title = "Title14",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 15,
                    creationTime = 1L,
                    title = "Title15",
                    author = "Author7",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 16,
                    creationTime = 1L,
                    title = "Title16",
                    author = "Author8",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 17,
                    creationTime = 1L,
                    title = "Title17",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 18,
                    creationTime = 1L,
                    title = "Title18",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                ),
                HNStoryResponse(
                    id = 19,
                    creationTime = 1L,
                    title = "Title19",
                    author = "Author1",
                    score = 1,
                    children = listOf()
                )
            )
        )
        binding.stories.layoutManager = LinearLayoutManager(activity)
        binding.stories.adapter = adapter
        adapter.onItemClick = { story ->
            Logger.i(TAG, "Clicked story ${story.id}")
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

    companion object {
        private const val TAG = "HomeFragment"
    }
}