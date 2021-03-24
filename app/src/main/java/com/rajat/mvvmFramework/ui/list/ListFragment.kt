package com.rajat.mvvmFramework.ui.list

import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajat.mvvmFramework.R
import com.rajat.mvvmFramework.base.BaseFragment
import com.rajat.mvvmFramework.base.ViewModelFactory
import com.rajat.mvvmFramework.model.Repo
import kotlinx.android.synthetic.main.screen_list.*
import javax.inject.Inject


/**
 * Created by Rajat Mittal on 23,March,2021
 */

class ListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: ListViewModel? = null
    override fun layoutRes(): Int {
        return R.layout.screen_list
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(activity!!, viewModelFactory).get(ListViewModel::class.java)

        recyclerView!!.adapter = RepoListAdapter(viewModel!!, this)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        observableViewModel()
    }


    private fun observableViewModel() {
        viewModel!!.getRepos().observe(activity!!,
            { repos: List<Repo?>? ->
                if (repos != null) recyclerView!!.visibility = View.VISIBLE
            })

        viewModel!!.getError().observe(activity!!,
            { isError: Boolean? ->
                if (isError != null) if (isError) {
                    tv_error!!.visibility = View.VISIBLE
                    recyclerView!!.visibility = View.GONE
                    tv_error!!.text = "An Error Occurred While Loading Data!"
                } else {
                    tv_error!!.visibility = View.GONE
                    tv_error!!.text = null
                }
            })

        viewModel!!.getLoading().observe(activity!!,
            { isLoading: Boolean? ->
                if (isLoading != null) {
                    loading_view!!.visibility = if (isLoading) View.VISIBLE else View.GONE
                    if (isLoading) {
                        tv_error!!.visibility = View.GONE
                        recyclerView!!.visibility = View.GONE
                    }
                }
            })
    }
}