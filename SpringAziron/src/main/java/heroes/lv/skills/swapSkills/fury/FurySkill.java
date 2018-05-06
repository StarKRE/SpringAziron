package heroes.lv.skills.swapSkills.fury;

import heroes.abstractHero.skills.swapSkill.AbstractSimplifiedSkill;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import management.actionManagement.actions.ActionEventFactory;
import management.battleManagement.BattleManager;
import management.playerManagement.Player;
import management.playerManagement.PlayerManager;

import java.util.List;

import static heroes.lv.skills.swapSkills.fury.FuryPropertySkill.*;

public final class FurySkill extends AbstractSimplifiedSkill {

    public FurySkill(final ImageView sprite, final ImageView description, final List<Media> voiceList) {
        super(NAME, SWAP_RELOAD, SWAP_REQUIRED_LEVEL, getSkillCoefficients(), sprite, description, voiceList);
    }

    @Override
    public final void use(final BattleManager battleManager, final PlayerManager playerManager) {
        final Player opponentPlayer = playerManager.getOpponentTeam().getCurrentPlayer();
        final Player currentPlayer = playerManager.getCurrentTeam().getCurrentPlayer();
        final heroes.abstractHero.hero.Hero currentHero = currentPlayer.getCurrentHero();
        final heroes.abstractHero.hero.Hero opponentHero = opponentPlayer.getCurrentHero();
        final int levelComparison = opponentHero.getLevel() - currentHero.getLevel();
        final double SKILL_COEFFICIENT = levelComparison > 0 ? (levelComparison + 1) * coefficients.get(0)
                : coefficients.get(0);
        final double DAMAGE = currentHero.getAttack() * SKILL_COEFFICIENT;
        if (opponentHero.getDamage(DAMAGE)){
            actionEvents.add(ActionEventFactory.getAfterDealDamage(currentPlayer, opponentHero, DAMAGE));
        }
    }

    @Override
    public final void showAnimation() {

    }
}