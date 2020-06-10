package com.glarimy.composit;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContainer implements Container {
	private List<Component> parts = new ArrayList<>();

	@Override
	public void add(Component part) {
		this.parts.add(part);

	}

	@Override
	public void hide() {
		for (Component part : parts)
			part.hide();
	}

	@Override
	public void show() {
		for (Component part : parts)
			part.show();
	}
}
