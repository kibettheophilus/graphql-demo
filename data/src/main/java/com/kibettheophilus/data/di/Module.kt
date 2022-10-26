import com.apollographql.apollo3.ApolloClient
import com.kibettheophilus.data.datasource.LaunchListRepositoryImpl
import com.kibettheophilus.domain.repository.LaunchListRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single<LaunchListRepository> {
        LaunchListRepositoryImpl(get())
    }

    single {
        ApolloClient.Builder().serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
            .build()
    }
}