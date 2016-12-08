package mac.secret;

public class AdditiveSecret implements Secret {

	@Override
	public Integer secret(Integer number) {
		return number;
	}

}
