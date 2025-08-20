use std::fmt::{self, Formatter, Display};

struct City {
    name: &'static str,
    lat: f32,
    lon: f32,
}

impl Display for City {
    fn fmt(&self, f: &mut Formatter) -> fmt::Result {
        let lat_c = if self.lat >= 0.0 {'N'} else {'S'};
        let lon_c = if self.lon >= 0.0 {'E'} else {'W'};
        write!(f, "{}: {:.3}°{}: {:.3}°{}",
        self.name, self.lat.abs(), lat_c, self.lon.abs(), lon_c)
    }
}

#[derive(Debug)]
struct Color {
    red: u8,
    green: u8,
    blue: u8,
}

impl Display for Color {
    fn fmt(&self, f: &mut Formatter) -> fmt::Result {
        write!(f, "RGB ({} {} {}) 0x{:2X}{:2X}{:2X}", self.red, self.green, self.blue, 
        self.red, self.green, self.blue)
    }
}

fn main() {
    for city in [
        City {name: "Uttarkashi", lat: 30.7306, lon: 78.4437},
        City {name: "Kashi", lat: 25.3176, lon: 82.9739},
        City {name: "Mathura", lat: 27.4924, lon: 77.6737}
    ] {
        println!("{}", city);
    }
    for color in [
        Color {red: 128, green: 255, blue: 90},
        Color {red: 0, green: 3, blue: 254},
        Color {red: 0, green: 0, blue: 0}
    ] {
        /**
         * RGB (128, 255, 90) 0x80FF5A
           RGB (0, 3, 254) 0x0003FE
           RGB (0, 0, 0) 0x000000
           want to print this
         */
        println!("{:?}", color);
    }
}