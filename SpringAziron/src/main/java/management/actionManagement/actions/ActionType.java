package management.actionManagement.actions;

public enum ActionType {
    BEFORE_DEAL_DAMAGE, AFTER_DEAL_DAMAGE
    , BEFORE_HEALING, AFTER_HEALING
    , BEFORE_ATTACK, DURING_ATTACK, AFTER_ATTACK
    , BEFORE_TREATMENT, AFTER_TREATMENT
    , BEFORE_USED_SKILL, AFTER_USED_SKILL
    , START_TURN, END_TURN, SKIP_TURN, SWAP_HEROES
    , AFTER_USED_BONUS, BEFORE_USED_BONUS, SHOWED_BONUSES
    , PLAYER_OUT, END_GAME, BEFORE_USED_POSSIBILITY, AFTER_USED_POSSIBILITY, BEFORE_USED_SWAP_SKILL, AFTER_USED_SWAP_SKILL, BEFORE_GETTING_EXPERIENCE, AFTER_GETTING_EXPERIENCE, DURING_GETTING_EXPERIENCE, DURING_DEAL_DAMAGE, DURING_TREATMENT, DURING_HEALING, GET_FRAME
}
