import com.kibettheophilus.data.LaunchListQuery
import com.kibettheophilus.data.LoginMutation
import com.kibettheophilus.domain.models.LaunchDataDomain
import com.kibettheophilus.domain.models.Launches
import com.kibettheophilus.domain.models.TokenDataDomain

fun LaunchListQuery.Data.toDomain() = LaunchDataDomain(
    launches = launches.toDomain()
)

fun LaunchListQuery.Launches.toDomain() = Launches(
    cursor = cursor
)


fun LoginMutation.Login.toDomain() = TokenDataDomain(
    token = token.toString()
)