package bonus.bashBonuses.bonuses.attack

import heroes.abstractHero.abilities.bonus.Bonus
import javafx.scene.image.ImageView
import management.actionManagement.actions.{ActionEvent, ActionType}
import management.playerManagement.Player
import management.service.components.handleComponent.EngineComponent
import management.service.engine.services.DynamicEngineService

final class AAcceleration(name: String, val id: Int, sprite: ImageView) extends Bonus(name, id, sprite)
  with DynamicEngineService {

  private val ATTACK_BOOST: Double = 1.0

  private val TURNS = 2

  override def use(): Unit = {
    val hero = playerManager.getCurrentTeam.getCurrentPlayer.getCurrentHero
    hero.setAttack(hero.getAttack + ATTACK_BOOST)
    val engine = actionManager.getEventEngine
    engine.addHandler(getPrototypeEngineComponent)
  }

  override def getPrototypeEngineComponent: EngineComponent = new EngineComponent {

    private var player: Player = _

    private var work: Boolean = true

    private var turnCounter: Int = TURNS

    override final def setup(): Unit = {
      player = playerManager.getCurrentTeam.getCurrentPlayer
    }

    override final def handle(actionEvent: ActionEvent): Unit = {
      if (turnCounter > 0) {
        val actionType = actionEvent.getActionType
        if (actionType == ActionType.START_TURN && actionEvent.getHero == player) {
          val hero = player.getCurrentHero
          hero.setAttack(hero.getAttack + ATTACK_BOOST)
          turnCounter -= 1
          actionManager.getEventEngine.setRepeatHandling(true)
        }
      } else {
        work = false
      }
    }

    override final def getName: String = "Acceleration"

    override final def getCurrentHero: Player = player

    override final def isWorking: Boolean = work

    override final def setWorking(able: Boolean): Unit = {
      work = able
    }
  }
}