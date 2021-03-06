package com.ikang.libmvi.base.ui.fragment

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ikang.libmvi.base.BaseViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout


/**
 * @author IK-zhulk
 * @version 1.0.0
 * @describe {@link #}
 */
abstract class BaseRefreshMoreFragment<VM : BaseViewModel, DB : ViewDataBinding> :
    BaseRefreshFragment<VM, DB>(),
    BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemLongClickListener {

    fun bindSwipeRecycler(
        refreshLayout: SmartRefreshLayout,
        recyclerView: RecyclerView,
        adapter: BaseQuickAdapter<*, BaseViewHolder>
    ) {
        bindSwipeRecycler(refreshLayout, recyclerView, LinearLayoutManager(activity), adapter)
    }


    fun bindSwipeRecycler(
        refreshLayout: SmartRefreshLayout,
        recyclerView: RecyclerView,
        lm: RecyclerView.LayoutManager,
        mAdapter: BaseQuickAdapter<*, BaseViewHolder>
    ) {
        bindRefreshLayout(refreshLayout)

        with(recyclerView) {
            layoutManager = lm
            adapter = mAdapter
        }
        mAdapter.onItemClickListener = this
        mAdapter.onItemLongClickListener = this
        mRefresh.setOnLoadMoreListener {
            onLoadMore()
        }
    }


    override fun onItemClick(
        adapter: BaseQuickAdapter<*, BaseViewHolder>,
        view: View,
        position: Int
    ) {

    }

    override fun onItemLongClick(
        adapter: BaseQuickAdapter<*, *>,
        view: View,
        position: Int
    ): Boolean {
        return false
    }


    abstract fun onLoadMore()


    /**
     * 加载完所有界面
     */
    fun stopLoadMore() {
        mRefresh.finishLoadMore()
    }

}