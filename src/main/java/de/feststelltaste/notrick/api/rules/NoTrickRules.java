package de.feststelltaste.notrick.api.rules;


public class NoTrickRules extends RuleSet {

    public NoTrickRules() {
        super.rules.add(new MustPlaySameSuitIfAvailableRule());
    }

}
