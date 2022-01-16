package com.urbansportsclub.assignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.urbansportsclub.assignment.adapter.GymStackAdapter
import com.urbansportsclub.assignment.databinding.GymListFragmentBinding
import com.urbansportsclub.assignment.viewmodel.GymViewModel
import com.yuyakaido.android.cardstackview.*

class GymListFragment : Fragment(), CardStackListener {

    private var _binding: GymListFragmentBinding? = null
    private val viewModel: GymViewModel by viewModels()
    private val binding get() = _binding!!
    private val mCardStackLayoutManager by lazy { CardStackLayoutManager(activity, this) }
    private lateinit var mAdapter: GymStackAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = GymListFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCardStackView()
        setupButton()

        viewModel.success.observe(viewLifecycleOwner, {
            mAdapter = GymStackAdapter((it))
            binding.cardStackView.adapter = mAdapter
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {
           if(it){
               binding.buttonContainer.visibility = View.GONE
               binding.loading.visibility=View.VISIBLE
               binding.loading.playAnimation()
           }else{
               binding.buttonContainer.visibility = View.VISIBLE
               binding.loading.pauseAnimation()
               binding.loading.visibility=View.GONE
           }
        })

        viewModel.getGymData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCardDragging(direction: Direction, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction) {

        if (direction.ordinal == 1) {
            binding.animationView.playAnimation()
        }

        if (mCardStackLayoutManager.topPosition == binding.cardStackView.adapter?.itemCount) {
            Toast.makeText(activity,
                "You have viewed all the available content... \nRefreshing...",
                Toast.LENGTH_SHORT).show()
            mAdapter.clearAdapter()
            viewModel.getGymData()
        }

    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View, position: Int) {
    }

    override fun onCardDisappeared(view: View, position: Int) {
    }


    private fun setupCardStackView() {
        initialize()
    }

    private fun setupButton() {

        binding.skipButton.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Slow.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            mCardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
        }


        binding.likeButton.setOnClickListener {
            binding.animationView.playAnimation()
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Slow.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            mCardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()

        }
    }

    private fun initialize() {
        mCardStackLayoutManager.setStackFrom(StackFrom.None)
        mCardStackLayoutManager.setTranslationInterval(8.0f)
        mCardStackLayoutManager.setScaleInterval(0.95f)
        mCardStackLayoutManager.setSwipeThreshold(0.3f)
        mCardStackLayoutManager.setMaxDegree(20.0f)
        mCardStackLayoutManager.setDirections(Direction.HORIZONTAL)
        mCardStackLayoutManager.setCanScrollHorizontal(true)
        mCardStackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        mCardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        binding.cardStackView.layoutManager = mCardStackLayoutManager
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

}