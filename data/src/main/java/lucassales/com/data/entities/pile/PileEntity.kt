package lucassales.com.data.entities.pile

import lucassales.com.data.entities.GameEntity

interface PileEntity : GameEntity {
    val matchId: Long
    val type: PileType
}