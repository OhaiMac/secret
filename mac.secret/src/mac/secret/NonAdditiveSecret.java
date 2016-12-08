package mac.secret;

public class NonAdditiveSecret implements Secret {

	@Override
	public Integer secret(Integer number) {
		return number * number;
	}

}
