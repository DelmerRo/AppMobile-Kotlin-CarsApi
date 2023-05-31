package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.UserManager
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels.ProfileViewModel
import com.squareup.picasso.Picasso


class ProfileFragment : Fragment() {
    private lateinit var ivProfilePhoto: ImageView
    private lateinit var tvProfileUsername: TextView
    private lateinit var profileViewModel: ProfileViewModel
    private var isProfileUpdated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_profile, container, false)
        ivProfilePhoto = vista.findViewById(R.id.ivProfilePhoto)
        tvProfileUsername = vista.findViewById(R.id.tvProfileUserName)
        return vista
    }

    override fun onResume() {
        super.onResume()
        if (!isProfileUpdated) {
            val userOnline = UserManager.user
            if (userOnline != null) {
                profileViewModel.updateProfileInfo(userOnline.getNamLastNam(), userOnline.getUrlImage())
                isProfileUpdated = true
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.profileName.observe(viewLifecycleOwner) { name ->
            tvProfileUsername.text = name
        }

        profileViewModel.profilePhotoUrl.observe(viewLifecycleOwner) { photoUrl ->
            Picasso.get().load(photoUrl).into(ivProfilePhoto)
        }
    }
}
