(

var nbPiste=2;

w=Window("window title", Rect(0, 0, 400, 400));
a=ScaledView(w, w.bounds)
.defSize_(1@(w.bounds.height/nbPiste))
.mouseMoveAction_{arg self, x, y;
self.drawFunc_{ Pen.fillRect(
Rect(x, y, self.defSize.x, self.defSize.y))};
	self.refresh
};
w.front;

~chgNbPiste={arg nb; a.defSize_(1@(a.bounds.height/nb))}
)

~chgNbPiste.(3)