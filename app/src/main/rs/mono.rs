#pragma version(1)
#pragma rs java_package_name(jp.bglb.bonboru.renderscriptsample)

const float3 mMonoVec = {0.298912f, 0.586611f, 0.114478f};

void init() {
}

void root(const uchar4 *v_in, uchar4 *v_out, uint32_t x, uint32_t y) {
    float4 color = rsUnpackColor8888(*v_in);
    float3 monoColor = dot(color.rgb, mMonoVec);
    *v_out = rsPackColorTo8888(monoColor);
}

