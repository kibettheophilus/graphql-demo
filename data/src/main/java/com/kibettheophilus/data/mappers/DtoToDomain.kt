import com.kibettheophilus.data.LaunchListQuery
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.Launches

fun LaunchListQuery.Data.toDomain() = LaunchDataDomain(
    launches = launches.toDomain()
)

fun LaunchListQuery.Launches.toDomain() = Launches(
    cursor = cursor
)