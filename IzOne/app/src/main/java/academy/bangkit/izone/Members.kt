package academy.bangkit.izone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Members(
    val name: String,
    val position: String,
    val description: String,
    val photos: Int,
    val birthday: String,
    val birthName: String,
): Parcelable
