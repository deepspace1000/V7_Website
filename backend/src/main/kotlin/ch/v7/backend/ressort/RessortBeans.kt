package ch.v7.backend.ressort

import ch.v7.backend.persistence.tables.daos.RessortDao
import org.springframework.context.support.beans

val ressortBeans = beans {
    bean<RessortService>()
    bean<RessortDao>()
}
