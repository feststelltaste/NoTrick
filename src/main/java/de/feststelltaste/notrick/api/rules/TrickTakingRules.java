package de.feststelltaste.notrick.api.rules;

public class TrickTakingRules extends RuleSet{
    
    public TrickTakingRules() {
	super.rules.add(new MustPlaySameSuitIfAvailableRule());
    }

}
