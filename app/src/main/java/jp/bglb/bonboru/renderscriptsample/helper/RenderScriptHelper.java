package jp.bglb.bonboru.renderscriptsample.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;

import jp.bglb.bonboru.renderscriptsample.ScriptC_mono;

public class RenderScriptHelper {

    private RenderScript mRenderScript;
    private ScriptC_mono mScriptMono;

    public RenderScriptHelper(Context context) {
        prepare(context);
    }

    private void prepare(Context context) {
        mRenderScript = RenderScript.create(context);
        mScriptMono = new ScriptC_mono(mRenderScript);
    }

    public Bitmap toMono(Bitmap in) {
        Allocation inAllocation = Allocation.createFromBitmap(mRenderScript, in);
        Allocation outAllocation = Allocation.createTyped(mRenderScript, inAllocation.getType());
        mScriptMono.forEach_root(inAllocation, outAllocation);
        Bitmap out = Bitmap.createBitmap(in.getWidth(), in.getHeight(), in.getConfig());
        outAllocation.copyTo(out);
        return out;
    }
}
