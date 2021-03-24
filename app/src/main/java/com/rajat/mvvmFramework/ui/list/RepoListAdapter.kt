package com.rajat.mvvmFramework.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.rajat.mvvmFramework.R
import com.rajat.mvvmFramework.model.Repo
import kotlinx.android.synthetic.main.view_repo_list_item.view.*


/**
 * Created by Rajat Mittal on 23,March,2021
 */

class RepoListAdapter constructor(
    viewModel: ListViewModel,
    lifecycleOwner: LifecycleOwner?) :
    RecyclerView.Adapter<RepoListAdapter.RepoViewHolder?>() {

    private val data: MutableList<Repo> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_repo_list_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    class RepoViewHolder(itemView: View) :

        RecyclerView.ViewHolder(itemView) {

        private var repo: Repo? = null

        fun bind(repo: Repo) {

            this.repo = repo
            itemView.tv_repo_name!!.text = repo.name
            itemView.tv_repo_description!!.text = repo.description
            itemView.tv_forks!!.text = repo.forks.toString()
            itemView.tv_stars!!.text = repo.stars.toString()
        }

    }

    init {
        viewModel.getRepos().observe(lifecycleOwner!!) { repos ->
            data.clear()
            if (repos != null) {
                data.addAll(repos)
                notifyDataSetChanged()
            }
        }
        setHasStableIds(true)
    }
}