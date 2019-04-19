package lucassales.com.data.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import lucassales.com.data.entities.Match
import lucassales.com.data.entities.pile.Pile

data class Solitaire(
    @Embedded val match: Match,
    @Relation(
        entity = Pile::class,
        parentColumn = "id",
        entityColumn = "match_id"
    ) val piles: List<PileWithCards>
)