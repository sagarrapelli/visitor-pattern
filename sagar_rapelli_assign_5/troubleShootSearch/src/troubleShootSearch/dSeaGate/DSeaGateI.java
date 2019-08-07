package troubleShootSearch.dSeaGate;

import java.util.List;

import troubleShootSearch.visitor.Visitor;

public interface DSeaGateI {
	public List<String> getTechSentence();
	public void accept(Visitor v);
}
