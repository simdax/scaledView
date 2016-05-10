ScaleViewPiste : ScaledView {

	var <nbPistes=2;
	*new{ arg p, b=(150@150).asRect;
		^super.new(p, b).initSVP
	}
	initSVP{
		this.defSize_(1@(this.bounds.height/nbPistes))
	}
	nbPistes_{
		arg nb;
		nbPistes=nb;
		this.defSize_(1@(this.bounds.height/nb))
	}
}

/*

a=ScaleViewPiste(nil, 200@200)
		.mouseMoveAction_{arg self, x, y;
			self.drawFunc_{ Pen.fillRect(
				Rect(x, y, self.defSize.x, self.defSize.y))};
			self.refresh
		}.front;
a.nbPistes=5
g
*/