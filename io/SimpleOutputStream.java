/**
 * SimpleOutputStreamです。
 * java.io.BufferedOutputStreamよりも大幅に大きいバッファを持っています。
 */

package io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class SimpleOutputStream extends FilterOutputStream {

	/**
	 * このstreamのバッファです
	 */
	private final byte buf[];

	/**
	 * このstreamのバッファに保持している文字の個数です
	 */
	private int count;

	/**
	 * コンストラクタです
	 * @param out
	 */
	public SimpleOutputStream(final OutputStream out) {
		this(out, 1<<17);
	}

	/**
	 * コンストラクタです
	 * @param out
	 * @param size
	 */
	public SimpleOutputStream(final OutputStream out, final int size) {
		super(out);
		if (size <= 0) {
			throw new IllegalArgumentException("Buffer size <= 0");
		}
		buf = new byte[size];
	}

	/**
	 * バッファにある文字をすべて書き込みます
	 * @throws IOException
	 */
	private void flushBuffer() throws IOException {
		if (count > 0) {
			out.write(buf, 0, count);
			count = 0;
		}
	}

	/**
	 * 引数をbyteとしてバッファに書き込みます
	 */
	@Override
	public void write(final int b) throws IOException {
		if (count >= buf.length) {
			flushBuffer();
		}
		buf[count++] = (byte)b;
	}

	/**
	 * 渡されたバッファのoffからlen文字だけバッファに書き込みます
	 */
	@Override
	public void write(final byte b[], final int off, final int len) throws IOException {
		if (len >= buf.length) {
			flushBuffer();
			out.write(b, off, len);
			return;
		}
		if (len > buf.length - count) {
			flushBuffer();
		}
		System.arraycopy(b, off, buf, count, len);
		count += len;
	}

	/**
	 * バッファにある文字をすべて書き込みます
	 */
	@Override
	public void flush() throws IOException {
		flushBuffer();
		out.flush();
	}
}
