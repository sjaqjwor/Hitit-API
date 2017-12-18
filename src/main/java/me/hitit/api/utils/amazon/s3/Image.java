package me.hitit.api.utils.amazon.s3;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	private String uri;
	private Header header;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Header {
		private String title;
		private double width;
		private double height;
		private double size;
		private Format format;
		private Timestamp ts;

		public enum Format {
			PNG((short) 0), JPG((short) 1), GIF((short) 2);

			private short code;

			private Format(short code) {
				this.code = code;
			}

			private short getFormat() {
				return code;
			}
		}
	}
}
