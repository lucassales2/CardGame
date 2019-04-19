package lucassales.com.data.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import lucassales.com.data.entities.SolitaireCard
import lucassales.com.data.entities.pile.Pile

data class PileWithCards(
    @Embedded val pile: Pile,
    @Relation(
        entity = SolitaireCard::class,
        parentColumn = "id",
        entityColumn = "pile_id"
    )
    val cards: List<SolitaireCard>
)