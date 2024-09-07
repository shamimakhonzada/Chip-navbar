package com.example.chip_navbar

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.chip_navbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedTap: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access views directly from the binding object
        val searchLayout = binding.searchLayout
        val nearbyLayout = binding.nearbyLayout
        val chatLayout = binding.chatLayout
        val profileLayout = binding.profileLayout

        val searchImage = binding.searchImage
        val nearbyImage = binding.nearbyImage
        val chatImage = binding.chatImage
        val profileImage = binding.profileImage

        val searchTxt = binding.searchTxt
        val nearbyTxt = binding.nearbyTxt
        val chatTxt = binding.chatTxt
        val profileTxt = binding.profileTxt

        // Set search fragment by default
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, SearchFragment::class.java, null)
            commit()
        }

        searchLayout.setOnClickListener {
            if (selectedTap != 1) {
                // Set search fragment
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, SearchFragment::class.java, null)
                    commit()
                }

                // Unselect other tabs
                nearbyTxt.visibility = View.GONE
                chatTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                nearbyImage.setImageResource(R.drawable.nearby_icon)
                chatImage.setImageResource(R.drawable.chat_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                binding.nearbyLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.chatLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.profileLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )

                searchTxt.visibility = View.VISIBLE
                searchImage.setImageResource(R.drawable.search_icon_selected)
                searchLayout.setBackgroundResource(R.drawable.round_back_search)

                // Create ScaleAnimation
                val scaleAnimation = ScaleAnimation(
                    1.0f, 1.1f, // Slightly larger scaling
                    1.0f, 1.1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                ).apply {
                    duration = 300
                    fillAfter = true
                    interpolator = android.view.animation.AccelerateDecelerateInterpolator()
                }

                searchLayout.startAnimation(scaleAnimation)

                selectedTap = 1
            }
        }

        nearbyLayout.setOnClickListener {
            if (selectedTap != 2) {
                // Set nearby fragment
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, NearbyFragment::class.java, null)
                    commit()
                }

                // Unselect other tabs
                searchTxt.visibility = View.GONE
                chatTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                searchImage.setImageResource(R.drawable.search_icon)
                chatImage.setImageResource(R.drawable.chat_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                binding.searchLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.chatLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.profileLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )

                nearbyTxt.visibility = View.VISIBLE
                nearbyImage.setImageResource(R.drawable.nearby_icon_selected)
                nearbyLayout.setBackgroundResource(R.drawable.round_back_nearby)

                // Create ScaleAnimation
                val scaleAnimation = ScaleAnimation(
                    1.0f, 1.1f, // Slightly larger scaling
                    1.0f, 1.1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                ).apply {
                    duration = 300
                    fillAfter = true
                    interpolator = android.view.animation.AccelerateDecelerateInterpolator()
                }

                nearbyLayout.startAnimation(scaleAnimation)

                selectedTap = 2
            }
        }

        chatLayout.setOnClickListener {
            if (selectedTap != 3) {
                // Set chat fragment
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, ChatFragment::class.java, null)
                    commit()
                }

                // Unselect other tabs
                nearbyTxt.visibility = View.GONE
                searchTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                nearbyImage.setImageResource(R.drawable.nearby_icon)
                searchImage.setImageResource(R.drawable.search_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                binding.nearbyLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.searchLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.profileLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )

                chatTxt.visibility = View.VISIBLE
                chatImage.setImageResource(R.drawable.chat_icon_selected)
                chatLayout.setBackgroundResource(R.drawable.round_back_chat)

                // Create ScaleAnimation
                val scaleAnimation = ScaleAnimation(
                    1.0f, 1.1f, // Slightly larger scaling
                    1.0f, 1.1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                ).apply {
                    duration = 300
                    fillAfter = true
                    interpolator = android.view.animation.AccelerateDecelerateInterpolator()
                }

                chatLayout.startAnimation(scaleAnimation)

                selectedTap = 3
            }
        }

        profileLayout.setOnClickListener {
            if (selectedTap != 4) {
                // Set profile fragment
                supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, ProfileFragment::class.java, null)
                    commit()
                }

                // Unselect other tabs
                nearbyTxt.visibility = View.GONE
                chatTxt.visibility = View.GONE
                searchTxt.visibility = View.GONE

                nearbyImage.setImageResource(R.drawable.nearby_icon)
                chatImage.setImageResource(R.drawable.chat_icon)
                searchImage.setImageResource(R.drawable.search_icon)

                binding.nearbyLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.chatLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )
                binding.searchLayout.setBackgroundColor(
                    resources.getColor(android.R.color.transparent, null)
                )

                profileTxt.visibility = View.VISIBLE
                profileImage.setImageResource(R.drawable.profile_icon_selected)
                profileLayout.setBackgroundResource(R.drawable.round_back_profile)

                // Create ScaleAnimation
                val scaleAnimation = ScaleAnimation(
                    1.0f, 1.1f, // Slightly larger scaling
                    1.0f, 1.1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                ).apply {
                    duration = 300
                    fillAfter = true
                    interpolator = android.view.animation.AccelerateDecelerateInterpolator()
                }

                profileLayout.startAnimation(scaleAnimation)

                selectedTap = 4
            }
        }
    }
}
